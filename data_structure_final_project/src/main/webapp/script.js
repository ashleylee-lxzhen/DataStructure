
function searchBooks() {
    // 示範用：隨機生成一些書籍搜尋結果
    var keywords = document.getElementById('searchField').value;
    var searchResults = document.getElementById('searchResults');
    searchResults.innerHTML = ''; // 清除現有搜尋結果

    for (let i = 0; i < 5; i++) {
        var resultDiv = document.createElement('div');
        resultDiv.className = 'searchResult';
        var link = document.createElement('a');
        link.href = 'https://www.google.com/search?q=' + encodeURIComponent(keywords) + '+book';
        link.target = '_blank';
        link.textContent = 'Book Result ' + (i + 1) + ' for "' + keywords + '"';
        resultDiv.appendChild(link);
        searchResults.appendChild(resultDiv);
    }
}
