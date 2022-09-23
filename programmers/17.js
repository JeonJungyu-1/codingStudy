//게임 맵 최단거리
function solution(maps) {
    const move = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    let row = maps[0].length - 1;
    let col = maps.length - 1;
    
    const queue = [[0, 0, 1]];
    
    while(queue.length) {
        const [x, y, answer] = queue.shift();

        if (x === col && y === row) return answer;

        for (let i = 0; i < 4; i++) {
            const [dx, dy] = move[i];
            const moveX = x + dx;
            const moveY = y + dy;
    
            if (moveX < 0 || moveY < 0 || moveX > col || moveY > row) continue;

            if (maps[moveX][moveY] === 0) continue;

            maps[moveX][moveY] = 0;

            queue.push([moveX, moveY, answer + 1]);
        }
    }
    return -1;
}
