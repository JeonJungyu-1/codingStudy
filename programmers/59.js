//단어 변환
function solution(begin, target, words) {
    let answer = 0;
    if (!words.includes(target)) return 0
    let sameWordNum = 0;
    const exploreWords = (depth, word, isExplored) => {
        for (let i = 0; i < words.length; i++) {
            sameWordNum = 0;
            if (!isExplored.includes(words[i])) {
                for (let j = 0; j < words[i].length; j++) {
                    if (word[j] === words[i][j]) {
                        sameWordNum++;
                    }
                }
                if (sameWordNum + 1 === words[i].length) {
                    if (words[i] === target) {
                        if (answer === 0 || answer > depth) {
                            answer = depth;
                        }
                    } else {
                        isExplored.push(words[i])
                        exploreWords(depth + 1, words[i], [...isExplored]); 
                    }
                }
            }
        }
    }
    
    exploreWords(1, begin, []);
    
    return answer;
}