//스킬트리
function solution(skill, skill_trees) {
    let answer = 0;
    for (let i = 0; i < skill_trees.length; i++) {
        let skillIndex = 0;
        for (let j = 0; j < skill.length; j++) {
            let tempIndex = skill_trees[i].indexOf(skill[j]);
            if (tempIndex === -1) {
                skillIndex = -1;
            } else {
                if (tempIndex >= skillIndex) {
                    if (skillIndex === -1) {
                        skillIndex = -2;
                        break;
                    } else {
                        skillIndex = tempIndex;
                    }
                        
                } else {
                    skillIndex = -2;
                    break;
                }
            }
        }    
        if (skillIndex >= -1) {
            answer++;
        }
    }
    return answer;
}