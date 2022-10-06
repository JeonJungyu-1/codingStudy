//모음사전
function solution(word) {
    let order = ["A", "E", "I", "O", "U"];
    let num = [781, 156, 31, 6, 1];
    let answer = 0;
    
    [...word].map((el, i) => {
        answer += (num[i] * order.indexOf(el) + 1);
    });
    
    
    return answer;
}