//JadenCase 문자열 만들기
function solution(s) {
    let stringArr = s.split(" ");
    let answer = stringArr.map(el => {
        if (!el) return el;
        return el[0].toUpperCase() + el.slice(1).toLowerCase();
    }).join(" ");
    return answer;
}