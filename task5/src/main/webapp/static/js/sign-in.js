$(function () {
        $(document).on('keyup', '#password, #confirm_password',
            function () {
                if ($('#password').val() === $('#confirm_password').val()) {
                    $('#message').html('Matching').css('color', 'green');
                } else {
                    $('#message').html('Not Matching').css('color', 'red');
                }
            });

        console.log("Error: " + errorMessage);

        if (errorMessage != null) {
            $('#error-message')
                .show()
                .html(errorMessage);
        } else {
            $('#error-message')
                .hide();
        }

    }
);