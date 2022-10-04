//이진 변환 반복하기
function solution(s) {
    let answer = [];
    let zeroNum = 0;
    let cnt = 0;
    while (s !== "1") {
        for (let i = 0; i < s.length; i++) {
            if (s[i] === "0") {
                if (i !== s.length - 1) {
                    s = s.slice(0, i) + s.slice(i + 1);
                    i--;
                } else {
                    s = s.slice(0, i);
                }
                zeroNum++;
            }
        }
        s = s.length.toString(2);
        cnt++;
    }
    answer = [cnt, zeroNum];
    return answer;
}