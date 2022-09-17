//같은 숫자는 싫어
function solution(arr) {
    let answer = []
    arr.map((el, index) => {
        if (!answer) {
            answer.push(el);
        } else if(el !== answer[answer.length - 1]) {
            answer.push(el);
        }
    })
    return answer;
}