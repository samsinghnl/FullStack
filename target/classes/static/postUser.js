$(document)
    .ready(
        function () {

            // SUBMIT FORM
            $("#customerForm").submit(function (event) {
                event.preventDefault();
                ajaxPost();
            });
            $('input:checkbox').click(function () {
                $('input:checkbox').not(this).prop('checked', false);
            });
            $('input[name="rquirednoemail"]:checked').each(function () {
                alert(this.value);
            });
            $('#phonenumber').keypress(function (e) {

                var charCode = (e.which) ? e.which : event.keyCode

                if (String.fromCharCode(charCode).match(/[^0-9]/g))

                    return false;

            });
            $('#fname').bind('keyup blur', function () {
                    var node = $(this);
                    node.val(node.val().replace(/[^a-z]/g, ''));

                }
            );
            $('#lname').bind('keyup blur', function () {
                    var node = $(this);
                    node.val(node.val().replace(/[^a-z]/g, ''));
                }
            );

            function ajaxPost() {
                var selectedValue = document.getElementById("Supervisor").value;
                // PREPARE FORM DATA
                alert($("#fname").val() + " " + $("#lname").val() + " " + $("#email").val() + " " + $("#phonenumber").val() + " " + selectedValue)
                var formData = {
                    firstname: $("#fname").val(),
                    lastname: $("#lname").val(),
                    email: $("#email").val(),
                    phonenumber: $("#phonenumber").val(),
                    supervisor: selectedValue
                }
                // DO POST
                $
                    .ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "http://localhost:8080/api/submit",
                        data: JSON.stringify(formData),
                        dataType: 'json',
                        success: function (result) {
                            console.log(result);
                        },
                        error: function (e) {
                            if (result.status == "success") {
                                alert("success");
                            } else {
                                $("#postResultDiv").html(
                                    "<strong>Error</strong>");
                            }
                            console.log(result);
                        }
                    });

            }

            $('#btn-submit').click(function () {

                $(".error").hide();
                var hasError = false;
                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

                var emailaddressVal = $("#email").val();
                if (emailaddressVal == '') {
                    alert("Please enter your email address.");
                    hasError = true;
                } else if (!emailReg.test(emailaddressVal)) {
                    alert("Enter a valid email address.");
                    hasError = true;
                }

                if (hasError == true) {
                    return false;
                }

            });
        })