function openPopupContainer(){
    document.getElementById('popupContainer').style.display = 'flex';
}



function closePopup(popupId) {
    document.getElementById('popupContainer').style.display = 'none';
        document.getElementById(popupId).style.display = 'none';

}

function confirmAdd() {
    var companyName = document.getElementById('addCompanyName').value;
    var ADName = document.getElementById('addADName').value;
    var ADCondition = document.getElementById('addADCondition').value;
    var slot = document.getElementById('addSlot').value;
    var cost = document.getElementById('addCost').value;
    var dayStart = document.getElementById('addDayStart').value;
    var dayEnd = document.getElementById('addDayEnd').value;

    if (companyName === "" || ADName === "" || ADCondition==="" || slot===""||cost===""||dayStart===""||dayEnd==="") {
        alert("값을 입력하지 않았습니다.");
    }
    else {
        document.getElementById('confirmAdd').addEventListener('click', function () {
            document.getElementById('popupContainer').style.display = 'none';
        });
    }
}

function openPopup(popupId){
    openPopupContainer();
    document.getElementById(popupId).style.display = 'flex';
}

function submitUI(){

}
