document.getElementById("ParisBookNow").addEventListener("click", function () {
    const packageID = "2";
    localStorage.setItem("selectedPackageID", packageID);
    window.location.href = "participantForm.html";
});
