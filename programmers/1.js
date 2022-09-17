//평균구하기
function solution(arr) {
    let answer = 0;
    arr.map((el) => {
        answer += el;
    })
    answer /= arr.length;
    return answer;
}