//예상 대진표
function solution(n,a,b) {
    let answer = 0;
    for (let i = 1; i < 21; i++) {
        if (n === Math.pow(2, i)) {
            answer = i;
            break;
        }
    }
    
    while (1) {
        if (a <= n/2) {
            if (b <= n/2) {
                answer--;
                n /= 2;
            } else {
                break;
            }
        } else {
            if (b <= n/2) {
                break;
            } else {
                answer--;
                n /= 2;
                a -= n;
                b -= n;
            }
        }
    }

    return answer;
}