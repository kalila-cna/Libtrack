<%@ taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" href="styles/login.css">
<s:set var="signup" value="true"></s:set>
<script>
    function validateEmail() {
        var emailField = document.getElementById('email-field');
        var emailValue = emailField.value;
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        if (!emailRegex.test(emailValue)) {
            alert('Please enter a valid email address.');
            return false; 
        }
        return true;
    }
</script>