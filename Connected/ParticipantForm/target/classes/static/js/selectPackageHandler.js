document.getElementById("bookNowButton").addEventListener("click", function () {
    const packageSelect = document.getElementById("packageSelect");
    const packageID = packageSelect.value;
    localStorage.setItem("selectedPackageID", packageID);
    window.location.href = "participantForm.html";
});
