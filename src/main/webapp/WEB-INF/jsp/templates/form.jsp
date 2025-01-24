<form class="rounded p-4 mb-3 w-100 w-md-25"
      style="background-color:#e3f2fd;" action="${pageContext.request.contextPath}/index"
      method="GET">
    <div class="row mb-3">
        <div class="col-12 col-md-6">
            <label for="start-date" class="form-label">Start</label>
            <input type="date" id="start-date" class="form-control form-control-lg"
                   aria-describedby="dateHelp1">
            <span id="dateHelp1"
                  class="form-text">Search start</span>
        </div>
        <div class="col-12 col-md-6">
            <label for="end-date" class="form-label">End</label>
            <input type="date" id="end-date" class="form-control form-control-lg"
                   aria-describedby="dateHelp2">
            <span id="dateHelp2"
                  class="form-text">Search end</span>
        </div>
    </div>
    <div class="row">
        <button type="submit" id="submit" class="btn btn-lg btn-primary mt-3">Submit</button>
    </div>
</form>