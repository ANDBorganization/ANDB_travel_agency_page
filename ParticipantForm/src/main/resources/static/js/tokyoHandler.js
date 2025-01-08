document.getElementById("TokyoBookNow").addEventListener("click", function () {
    const packageID = "3";
    localStorage.setItem("selectedPackageID", packageID);
    window.location.href = "participantForm.html";
});
