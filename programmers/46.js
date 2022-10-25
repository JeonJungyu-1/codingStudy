//음양 더하기
function solution(absolutes, signs) {
    let answer = 0;
    absolutes.map((el, index) => {
        if (signs[index]) {
            answer += el;
        } else {
            answer -= el;
        }
    })
    return answer;
}