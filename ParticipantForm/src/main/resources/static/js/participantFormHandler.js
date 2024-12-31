function createParticipantField(index) {
    const participantDiv = document.createElement('div');
    participantDiv.classList.add('participant');

    participantDiv.innerHTML = `
        <h3>Participant ${index}</h3>
        <label for="name${index}">Name:</label>
        <input type="text" id="name${index}" name="name${index}" required>

        <label for="surname${index}">Surname:</label>
        <input type="text" id="surname${index}" name="surname${index}" required>

        <label for="dateOfBirth${index}">Date of Birth:</label>
        <input type="date" id="dateOfBirth${index}" name="dateOfBirth${index}" required>
        
        <label for="address${index}">Address:</label>
        <input type="text" id="address${index}" name="address${index}" required>

        <label for="email${index}">Email:</label>
        <input type="email" id="email${index}" name="email${index}" required>

        <label for="phone${index}">Phone:</label>
        <input type="tel" id="phone${index}" name="phone${index}" required>
    `;

    return participantDiv;
}

// Add a participant field to the container
function addParticipantField() {
    const container = document.getElementById('participantsFieldsContainer');
    const participantCount = container.childElementCount + 1;
    const newField = createParticipantField(participantCount);
    container.appendChild(newField);
}

// Load one participant at start
document.addEventListener('DOMContentLoaded', () => {
    addParticipantField();

    const packageID = localStorage.getItem('selectedPackageID');

    if (!packageID) {
        alert("Package ID is missing!");
        return;
    }

    // Store as hidden input
    const packageInput = document.createElement('input');
    packageInput.type = 'hidden';
    packageInput.name = 'packageId';
    packageInput.value = packageID;
    document.getElementById('participantForm').appendChild(packageInput);
});

// Event listener for the "Add Participant" button
document.getElementById('addParticipantButton').addEventListener('click', addParticipantField);

// Submission
document.getElementById('participantForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const participants = [];
    const container = document.getElementById('participantsFieldsContainer');
    const packageId = document.querySelector('[name="packageId"]').value;

    for (let i = 0; i < container.childElementCount; i++) {
        const name = document.getElementById(`name${i + 1}`).value.trim();
        const surname = document.getElementById(`surname${i + 1}`).value.trim();
        const dateOfBirth = document.getElementById(`dateOfBirth${i + 1}`).value;
        const address = document.getElementById(`address${i + 1}`).value.trim();
        const email = document.getElementById(`email${i + 1}`).value.trim();
        const phone = document.getElementById(`phone${i + 1}`).value.trim();

        participants.push({ name, surname, dateOfBirth, address, email, phone });
    }

    const customerIds = participants.map(participant => participant.id);
    const employeeId = 1; // NOT THERE - employee ID

    /// CURRENTLY DELETED (Booking Controller) - so will not work:
    // try {
    //     const response = await fetch('/api/bookings', {
    //         method: 'POST',
    //         headers: { 'Content-Type': 'application/json' },
    //         body: JSON.stringify({
    //             customerIds: customerIds,
    //             packageId: packageId,
    //             employeeId: employeeId,
    //             travelers: participants.length
    //         }),
    //     });
    //     if (response.ok) {
    //         alert('Booking created successfully!');
    //     } else {
    //         const errors = await response.json();
    //         alert('Error: ' + errors);
    //     }
    // } catch (error) {
    //     alert('An error occurred: ' + error.message);
    // }

    try {
        const response = await fetch('/api/participants', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(participants),
        });

        if (response.ok) {
            //
        } else {
            const errors = await response.json();
            alert('Validation errors:\n' + errors.join('\n'));
        }
    } catch (error) {
        alert('An error occurred: ' + error.message);
    }
});
