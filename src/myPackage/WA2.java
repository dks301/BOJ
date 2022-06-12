package myPackage;

import java.util.*;

/*
문제 설명
당신은 Simple Language라는 프로그래밍 언어를 실행하는 프로그램을 작성해야 합니다.

Simple Language는 다음과 같은 특징을 갖고 있습니다.

명령어는 앞에서부터 순차적으로 실행됩니다.
명령어는 두 가지로 이루어져 있습니다.
변수 생성과 변수 값 대입: 변수명=숫자 의 형태로 이루어져 있습니다. 이 명령어를 실행하면, 변수를 생성하고 숫자를 변수에 대입합니다.
변수 값 출력: print 변수명 의 형태로 이루어져 있습니다. 이 명령어를 실행하면, 변수명=변수 값 을 출력하게 됩니다. 이때 존재하지 않는 변수의 이름을 넣게 된다면, error를 출력합니다.
변수는 동일한 이름으로 여러 개 생성할 수 있으며, 서로 값에 영향을 주지 않습니다.
블록이라는 개념이 존재합니다.
블록이란 생성한 변수가 존재하는 위치입니다. 즉, 해당 블록이 사라지면 블록에 포함되는 변수는 사라집니다.
블록은 명령어 앞의 . 개수로 구분하며, 다른 블록을 포함할 수 있습니다.
다른 블록에 포함된 블록에서 변수의 값을 출력할 때, 존재하는 동일한 이름의 변수가 여러 개라면, 가장 나중에 생성된 변수의 값을 출력합니다.
블록을 구분하는 방법은 다음과 같습니다.

현재 명령어의 .개수가 이전 명령어의 .개수랑 동일할 때: 이전 명령어와 동일한 블록입니다.
현재 명령어의 .개수가 이전 명령어의 .개수보다 많아졌을 때: 이전에 존재하던 블록에 포함된 새로운 블록을 생성합니다.
현재 명령어의 .개수가 이전 명령어의 .개수보다 적어졌을 때: 블록이 사라지는 지점입니다. 한 번에 여러 블록이 사라질 수 있습니다. 단, 블록이 사라지면서 새로운 블록을 생성하는 명령어는 주어지지 않습니다.
첫 번째 명령어 일 때에는 첫 번째 블록이 생성됩니다. 첫 번째 명령어에도 .이 포함될 수 있습니다.
다음과 같은 명령어들이 있다고 가정해 봅시다.

(01) a=3
(02) ..a=4
(03) ..b=3
(04) ..print a
(05) .......a=6
(06) .......print a
(07) .......print b
(08) ..print a
(09) ....a=7
(10) ....print a
(11) print a
(12) print b
(13) a=4
(14) print a
(15) ...print a
앞에서부터 순차적으로 실행해야 하므로 1번째 줄에 있는 명령어부터 숫자가 커지는 순서대로 실행합니다.

실행되는 명령어의 번호	명령어	명령어 실행 결과
1	a=3	첫 번째 명령어 이므로 첫 번째 블록이 생성됩니다. a변수가 생성되고 3의 값을 가집니다.
2	..a=4	첫 번째 블록에 포함되는 두 번째 블록이 생성됩니다. 두 번째 블록에 a변수가 생성되고 4의 값을 가집니다. 이때, 1번째 명령어에서 생성된 변수와 다른 변수입니다. 즉, 서로 영향을 주지 않습니다.
3	..b=3	두 번째 블록입니다. b변수가 생성되고 3의 값을 가집니다.
4	..print a	두 번째 블록입니다. 변수 a를 출력합니다. 이때 존재하는 a는 1번 명령어와, 2번 명령어에서 생성된 것 두 가지입니다. 그중 가장 나중에 생성된 변수를 출력합니다. 따라서 a=4를 출력합니다.
5	.......a=6	두 번째 블록에 포함되는 세 번째 블록이 생성됩니다. 세 번째 블록에 a변수가 생성되고 6의 값을 가집니다. 이때, 생성된 a는 1번 명령어에서 생성된 a와 2번 명령어에서 생성된 a와는 다른 변수입니다. 즉, 서로 영향을 주지 않습니다.
6	.......print a	세 번째 블록입니다. 변수 a를 출력합니다. 이때 존재하는 a는 세 개입니다. 그중 가장 나중에 생성된 변수의 값을 출력합니다. 따라서 a=6을 출력합니다.
7	.......print b	세 번째 블록입니다. 변수 b를 출력합니다. 이때 존재하는 b는 한 개입니다. 따라서 b=3을 출력합니다.
8	..print a	세 번째 블록이 사라졌습니다. 따라서 5번 명령어에서 생성한 a변수가 사라지게 됩니다. 변수 a를 출력합니다. 이때 존재하는 a는 두 가지입니다. 1, 2번 명령어에서 생성된 a만 존재하고, 5번 명령어에서 생성된 a는 블록이 끝나 삭제되었기 때문에 존재하지 않습니다. 따라서 존재하는 a 중 가장 나중에 생성된 a=4를 출력합니다.
9	....a=7	두 번째 블록에 포함되는 네 번째 블록이 생성됩니다. 생성된 블록에 a변수가 생성되고 7의 값을 가집니다.
10	....print a	네 번째 블록입니다. 변수 a를 출력합니다. 이때 존재하는 a는 세 개입니다. 가장 나중에 생성된 a=7을 출력합니다.
11	print a	첫 번째 블록입니다. 9번 명령어에서 생성된 네 번째 블록과 2번 명령어에서 생성된 두 번째 블록이 동시에 사라졌습니다. 따라서 2, 3, 9번 명령어에서 생성한 변수들이 모두 사라졌습니다. 따라서 존재하는 a는 1번 명령어에서 생성된 한 가지뿐입니다. 따라서 a=3을 출력합니다.
12	print b	첫 번째 블록입니다. 3번 명령어에서 생성된 b가 삭제되었기 때문에 현재 블록에는 b 변수가 존재하지 않습니다. 따라서 error를 출력합니다.
13	a=4	첫 번째 블록입니다. 새로운 a변수가 생성되고 4의 값을 가집니다.
14	print a	첫 번째 블록입니다. 현재 블록에서 접근할 수 있는 a의 값은 1번과 13번 명령어에서 생성된 두 가지가 있습니다. 가장 나중에 생성된 a=4를 출력합니다.
15	...print a	첫 번째 블록에 포함되는 다섯 번째 블록이 생성됩니다. 현재 블록에서 접근할 수 있는 a의 값은 1번과 13번 명령어에서 생성된 두 가지가 있습니다. 가장 나중에 생성된 a=4를 출력합니다.
실행해야 하는 명령어들이 순차적으로 들어가 있는 문자열 배열 code가 매개변수로 주어질 때, 해당 명령어들이 모두 실행된 뒤 출력된 결과를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ code의 길이 ≤ 1,000
code의 원소는 두 가지 형태로 이루어져 있습니다.
1: 변수명=숫자
2: print 변수명
변수명은 항상 한 글자이며, 영어 소문자로 표현됩니다.
1 ≤ 숫자 < 100,000,000
명령어의 앞에 .이 여러 개 포함될 수 있습니다.
3 ≤ code 원소의 길이 ≤ 30
print 변수명 명령어는 항상 한 개 이상 주어집니다.
항상 유효한 블록의 형태만 주어집니다. 즉, 다음과 같은 형태의 블록은 주어지지 않습니다.
(1) a=3
(2) ..print a
(3) .print a
위와 같은 형태라면, 3번째 줄에서 기존의 블록을 닫으면서 새로운 블록을 생성하는 유효하지 않은 블록의 형태가 됩니다. 이러한 입력은 주어지지 않습니다.

입출력 예
code	result
["a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"]	["a=4", "a=6", "b=3", "a=4", "a=7", "a=3", "error", "a=4", "a=4"]
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.
 */
public class WA2 {
  private static final String PRINT = "print";
  private static final String ERROR = "error";
  private static final String DOT = ".";
  private static final String EQUAL = "=";
  private static final String SPACE = " ";

  public static void main(String[] args) {
    System.out.println(isPrint("....print=3"));
  }

  public static String[] solution(String[] code) {
    List<String> answer = new ArrayList<>();

    final Map<String, Integer>[] map = new HashMap[30];
    int beforeBlock = countDepth(code[0]);
    map[beforeBlock] = new HashMap<>();
    if (isPrint(code[0])) {
      answer.add(ERROR);
    } else {
      final String[] variableAndNumber = extractVariableAndNumber(extractCommand(code[0]));
      map[beforeBlock].put(variableAndNumber[0], Integer.parseInt(variableAndNumber[1]));
    }

    for (int i = 1; i < code.length; i++) {
      int currentBlock = countDepth(code[i]);
      if (beforeBlock < currentBlock) {
        map[currentBlock] = new HashMap<>();
        solve(code, answer, map, i, currentBlock);
      } else if(beforeBlock == currentBlock) {
        solve(code, answer, map, i, currentBlock);
      } else {
        closeBlocks(map, currentBlock, beforeBlock);
        solve(code, answer, map, i, currentBlock);
      }
      beforeBlock = currentBlock;
    }
    return answer.stream().toArray(String[]::new);
  }

  private static void solve(final String[] code, final List<String> answer, final Map<String, Integer>[] map, final int i, final int currentBlock) {
    if (isPrint(code[i])) {
      final String variable = extractPrintVariable(extractCommand(code[i]));
      final int lastVariableNumber = findLastVariableNumber(map, currentBlock, variable);
      if (lastVariableNumber != -1) {
        answer.add(variable + EQUAL + lastVariableNumber);
      } else {
        answer.add(ERROR);
      }
    } else {
      final String[] variableAndNumber = extractVariableAndNumber(extractCommand(code[i]));
      map[currentBlock].put(variableAndNumber[0], Integer.parseInt(variableAndNumber[1]));
    }
  }

  public static int countDepth(final String code) {
    return code.lastIndexOf(DOT) == -1 ? 0 : code.lastIndexOf(DOT) + 1;
  }

  public static String extractCommand(final String code) {
    return code.substring(countDepth(code));
  }

  public static boolean isPrint(final String code) {
    return code.contains(PRINT);
  }

  public static String[] extractVariableAndNumber(final String command) {
    return command.split(EQUAL);
  }

  public static String extractPrintVariable(final String command) {
    return command.split(SPACE)[1];
  }

  public static int findLastVariableNumber(final Map<String, Integer>[] map, final int currentBlock, final String variable) {
    for (int i = currentBlock; i >= 0; i--) {
      if (map[i] != null && map[i].containsKey(variable)) {
        return map[i].get(variable);
      }
    }
    return -1;
  }

  public static void closeBlocks(final Map<String, Integer>[] map, final int currentBlock, final int beforeBlock) {
    for (int i = currentBlock + 1; i <= beforeBlock; i++) {
      map[i] = null;
    }
  }
}
