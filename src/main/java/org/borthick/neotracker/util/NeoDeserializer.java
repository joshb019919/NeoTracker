package org.borthick.neotracker.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.borthick.neotracker.model.NearEarthObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NeoDeserializer extends StdDeserializer<List<NearEarthObject>> {

    public NeoDeserializer() {
        this(null);
    }

    protected NeoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<NearEarthObject> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        List<NearEarthObject> objects = new ArrayList<>();
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        JsonNode nodeObjects = node.get("near_earth_objects");
        nodeObjects.elements().forEachRemaining(e -> e.forEach(obj -> {
            NearEarthObject object = new NearEarthObject();
            long id = obj.get("id").asLong();

            String name = obj.get("name").asText();
            BigDecimal kmMax = obj.get("estimated_diameter").get("kilometers").get("estimated_diameter_max").decimalValue();
            BigDecimal kmMin = obj.get("estimated_diameter").get("kilometers").get("estimated_diameter_min").decimalValue();
            BigDecimal ftMax = obj.get("estimated_diameter").get("feet").get("estimated_diameter_max").decimalValue();
            BigDecimal ftMin = obj.get("estimated_diameter").get("feet").get("estimated_diameter_min").decimalValue();
            boolean hazard = obj.get("is_potentially_hazardous_asteroid").asBoolean(false);
            String date = obj.get("close_approach_data").get(0).get("close_approach_date").asText(String.valueOf(LocalDate.now()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Timestamp timestamp = Timestamp.valueOf(LocalDate.parse(date, formatter).atStartOfDay());
            BigDecimal kps = BigDecimal.valueOf(obj.get("close_approach_data").get(0).get("relative_velocity").get("kilometers_per_second").asDouble(-1.0));
            BigDecimal mph = BigDecimal.valueOf(obj.get("close_approach_data").get(0).get("relative_velocity").get("miles_per_hour").asDouble(-1.0));
            BigDecimal missKm = BigDecimal.valueOf(obj.get("close_approach_data").get(0).get("miss_distance").get("kilometers").asDouble(-1.0));
            BigDecimal missMi = BigDecimal.valueOf(obj.get("close_approach_data").get(0).get("miss_distance").get("miles").asDouble(-1.0));
            String orbiting = obj.get("close_approach_data").get(0).get("orbiting_body").asText("Earth");
            boolean sentry = obj.get("is_sentry_object").asBoolean(false);

            object.setId(id);
            object.setName(name);
            object.setKiloDiamMax(kmMax);
            object.setKiloDiamMin(kmMin);
            object.setFeetDiamMax(ftMax);
            object.setFeetDiamMin(ftMin);
            object.setIsHazard(hazard);
            object.setCloseApproachDate(timestamp);
            object.setKilometersPerSecond(kps);
            object.setMilesPerHour(mph);
            object.setKiloMissDist(missKm);
            object.setMilesMissDist(missMi);
            object.setOrbiting(orbiting);
            object.setIsSentry(sentry);

            objects.add(object);
        }));

        return objects;
    }
}
