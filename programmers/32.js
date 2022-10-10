//프린터
function solution(priorities, location) {
    let answer = 1;
    while(priorities.length) {
        if (priorities[0] < Math.max(...priorities.slice(1))) {
            priorities.push(priorities.shift());
            if (location === 0) {
                location = priorities.length - 1;                
            } else {
                location--;
            }
        } else {
            if (location === 0) {
                break;
            } else {
                priorities.shift();
                answer++;
                location--;
                continue;
            }
           
        }
    }
    answer += location;
    return answer;
}
