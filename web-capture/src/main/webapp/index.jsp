<html>
<body>
<h2>Hello World!</h2>

<form action="/capture" target="_blank">
    <input type="text" name="url" maxlength="200"/>
    <br/>
    <input type="submit"/>
</form>
</body>
</html>
<script>
    javascript:(function ($) {
        var a = location.href;
        var b = "http://localhost:8080/capture?url=" + a;
        location.href = b;
    })(jQuery)
</script>
