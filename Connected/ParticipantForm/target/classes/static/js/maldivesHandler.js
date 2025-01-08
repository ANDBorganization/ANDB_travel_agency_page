document.getElementById("MaldivesBookNow").addEventListener("click", function () {
    const packageID = "1";
    localStorage.setItem("selectedPackageID", packageID);
    window.location.href = "participantForm.html";
});
