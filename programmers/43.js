//점프와 순간 이동
function solution(n) {
    let answer = 0;
    while(n !== 0) {
        if (n % 2 === 1) {
            answer += 1;
        }
        n =  parseInt(n / 2);
    }

    return answer;
}