package myPackage;
/*
 * 미세먼지 안녕!
 * 공기청정기는 항상 왼쪽 열에 설치, 크기는 두 행을 차지
 * 1초동안 아래에 적힌 일이 순서대로 일어난다.
 * 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
 *     (r,c)에 있는 미세먼지는 인접한 네 방향으로 확산.
 *     인접한 방향에 공기청정기가 있거나, 칸이 없으면 확산x
 *     확산되는 양은 Ar,c/5이고 소수점은 버린다.
 *     (r,c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5) * (확산된 방향의 개수)
 * 2. 공기청정기가 작동한다.
 *     공기청정기에서는 바람이 나온다.
 *     위쪽 공기청정기의 바람은 반시계방향으로, 아래쪽 바람은 시계방향으로 순환
 *     바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
 *     공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화
 * T초가 지난 후 방에 남아있는 미세먼지의 양을 출력.
 * 
 * 첫쨰줄: R,C,T(6<=R,C<=50, 1<=T<=1,000)
 * 둘째줄~R개줄): Ar,c(-1<=Ar,c<=1,000) 공기청정기가 설치된 곳은 -1
 * 공기청정기는 위아래로 2칸, 마진 두 칸 이상
 */
public class BOJ17144 {
	public static void main(String[] args) throws Exception {
		
	}
}
