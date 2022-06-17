# 컴퓨터 알고리즘 11주차 과제
## Job scheduling
### 201701643 고희수
------------------------

#### 1. 알고리즘 소개
작업 스케줄링이란 작업의 수행 시간이 중복되지 않도록 모든 작업을 가장 적은 수의 기계에 배정하는 문제이다.

1. 빠른 시작시간 작업 우선 (Earliest start time first) 배정
2. 빠른 종료시간 작업 우선 (Earliest finish time first) 배정
3. 짧은 작업 우선 (Shortest job first) 배정
4. 긴 작업 우선 (Longest job first) 배정
> 위의 네가지 중 첫 번째 알고리즘을 제외하고 나머지 세가지는 항상 최적해를 찾지 못한다.
-----------------------
#### 2. 소스코드

```java
        ArrayList<Job> L = getJobs();
        arraysort(L);
        int m = 2; // 기계 갯수
        int index = 0;
        Job job;
```
> arraysort() 함수 이용

```java
        while(index < L.size()) { //
            job = L.get(index);
            if ( isIdleMachine(m, job)){
            }
            else{
                ArrayList<Job> temp = new ArrayList<Job>();
                temp.add(job);
                Machine tempM = new Machine();
                tempM.setJobs(temp);
                m.add(tempM);
            }
```

-----------------------
#### 3. 시간복잡도와 근사비율
![image](https://user-images.githubusercontent.com/51106969/118675400-8b03ed80-b835-11eb-8179-72b05578342f.png)

> 시간복잡도 : n * O(m) + O(m) = O(mn)

> 가장 마지막으로 배정된 작업 i(5) 가 T(=3) 부터 수행되며, 모든 작업이 T+ti(=8)에 종료된 것을 보이고 있다. 그러므로 OPT' = 8이다.

> T'(=3)은 작업 i(5)를 제외한 모든 작업의 수행시간의 합을 기계의 수 m(=2)으로 나눈 값이다. 즉 T<=T'이 된다.

![image](https://user-images.githubusercontent.com/51106969/118675972-ff3e9100-b835-11eb-9501-3286cfd9f5bb.png)

> OPT'(=8) =  T+ti(=8) <= T'+ti(=8) <= 2OPT(=16)


