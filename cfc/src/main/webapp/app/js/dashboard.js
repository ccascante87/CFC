/**
 * VMC Confidential
 * 
 */
$(document).ready(function () {
    loadHome();
});

$('.logo').click(function () {
    loadHome();
});

$('.side-menu-item').click(function () {
    var htmlFile = $(this).data('htmlfile');
    loadHTML(htmlFile);
});

function loadHome() {
    var homepageHtml = 'homepage';
    loadHTML(homepageHtml);
}

function loadHTML(htmlFile) {
    var wrapper = $('#content-wrapper');
    if (htmlFile != undefined) {
        var htmlSnippet = 'app/snippets/' + htmlFile + '.html';
        $.ajax({
            url: htmlSnippet,
            type: 'GET',
            cache: false,
            success: function (html) {
                wrapper.html(html);
            }
        });
    }
}