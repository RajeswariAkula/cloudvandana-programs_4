document.getElementById("submit-button").addEventListener("click", function (e) {
        // Prevent the default form submission
        e.preventDefault();
        
        // Check if all fields are filled
        const requiredFields = ["firstName", "lastName", "dob", "country", "profession", "email", "mobile"];
        let isValid = true;
        for (const field of requiredFields) {
            if (!document.getElementById(field).value.trim()) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            alert("Please fill in all the required fields.");
        } else {
            // All fields are filled, submit the form
            document.getElementById("surveyForm").submit();
            alert("Form is submitted");
        }
    });
// Add this JavaScript code below the previous JavaScript code
document.getElementById("submit-button").addEventListener("click", function () {
    // This will trigger the form submission
    document.getElementById("surveyForm").submit();
});

document.getElementById("reset").addEventListener("click", function () {
    document.getElementById("popup").style.display = "none";
});


