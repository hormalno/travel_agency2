//Execute when page is open and HTML is ready
$(function () {
    loadReviews();
    hideAddItemInputs();
    $('#btnSave').click(saveItem);
    $('#btnCancel').click(hideAddItemInputs);
    $('#addTaskButton').click(showAddItemInputs);
});

//Show Add Items
function showAddItemInputs() {
    $('#addItemsInputs').show();
}

//Hide Add Items
function hideAddItemInputs() {
    $('#addItemsInputs').hide();
}

//Get JSON Data
function loadReviews() {
    var productId = $('#loadAllReviews').attr('productId');
    $.ajax({
        type: 'GET',
        url: '/reviews/' + productId,
        contentType: 'application/json',
        dataType: 'json',
        success: function (reviews) {
            loadAllReviews(reviews);
        }
    });
}

function formatDate(dateInNumber) {
    var date = new Date(dateInNumber);
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    return day + '/' + month + '/' + year;
}

function loadAllReviews(reviews) {
    $.each(reviews, function(i, review){
    var reviewContent = review.content;
    var reviewScore = review.score;
    var firstName = review.userFirstName;
    var lastName = review.userLastName;
    var releaseDate = formatDate(review.releaseDate);
    $('#loadAllReviews')
        .append($('<div></div>')
            .addClass("comm-info-txt")
            .append($('<h5></h5>')
                .text(firstName + ' ' + lastName)
                .append($('<span></span>')
                    .addClass("pull-right")
                    .text(releaseDate)))
            .append($('<p></p>')
                .text("\"" + reviewContent + "\""))
            .append($('<a></a>')
                .text('Score: ' + reviewScore + '/5'))
    )});
}

function saveItem() {
    var productId = $('#loadAllReviews').attr('productId');
    var review = {};
    review.content = $('#newInputReview').val();
    review.score = $('#newInputScore').val();
    $.ajax({
        type: 'POST',
        url: '/reviews/' + productId,
        data: JSON.stringify(review),
        dataType: 'json',
        contentType: 'application/json',
        success: hideAddItemInputs()
    });
}


