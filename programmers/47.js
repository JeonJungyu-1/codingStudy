//크레인 인형뽑기 게임
function solution(board, moves) {
    let answer = 0;
    let store = [];
    for (let i = 0; i < moves.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[j][moves[i] - 1] !== 0) {
                if (store[store.length - 1] === board[j][moves[i] - 1]) {
                    store.pop(); 
                    answer += 2;
                } else {
                    store.push(board[j][moves[i] - 1]);
                }
                board[j][moves[i] - 1] = 0;  
                break;
            }
        }
    }
    return answer;
}