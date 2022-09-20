//타겟 넘버
function solution(numbers, target) {
    let answer = 0;
    
    function dfs(depth, sum, numbers, target) {
        if (numbers.length === depth) {
            if (sum === target) {
                answer++;
            }
            return null;
        }

        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
    
    dfs(0, 0, numbers, target);
    return answer;
}

