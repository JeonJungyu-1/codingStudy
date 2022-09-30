//피로도
//https://katastrophe.tistory.com/59 참고
function solution(k, dungeons) {
    let answer = 0;
    let isVisit = new Array(dungeons.length);
    
    function dfs(index, energy, count) {
        isVisit[index] = true;
        energy -= dungeons[index][1];
        dungeons.map((el, i) => {
            if (!isVisit[i] && el[0] <= energy) {
                dfs(i, energy, count + 1)
            }
        })
        answer = Math.max(answer, count);
        isVisit[index] = false;
    }
    
    
    dungeons.map((el, i) => {
        if (k >= el[0]) {
            dfs(i, k, 1)
        }
    })
    
    return answer;
}

