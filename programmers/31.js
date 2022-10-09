//기능개발
function solution(progresses, speeds) {
    let answer = [];
    let cnt = 0;
    while (1) {
        if (!progresses.length) {
            break;
        }
        for (let i = 0; i < progresses.length; i++) {
            if (progresses[i] < 100) {
                progresses[i] += speeds[i];
            } 
            if (progresses[i] >= 100 && i === 0) {
                progresses.shift();
                speeds.shift();
                i--;
                cnt++;
            }
            
        }
        if (cnt) {
            answer.push(cnt);
            cnt = 0;
        }
        
        
    }
    return answer;
}