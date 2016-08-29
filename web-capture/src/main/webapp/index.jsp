<html>
<body>

<h2>Hello World!</h2>

</body>
</html>

<script>
    javascript:(function ($) {
        var a = location.href;
        var b = "http://localhost:8080/capture?url=" + a;
        location.href = b;
    })(jQuery)

    javascript:(function ($) {
        var a = location.href;
        var b = "http://localhost:8080/download?url=" + a;
        location.href = b;
    })(jQuery)
</script>
