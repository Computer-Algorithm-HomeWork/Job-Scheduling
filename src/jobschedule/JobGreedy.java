package jobschedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobGreedy<Machine, Job> {
    private ArrayList<Machine> ms; // 기계 리스트

    public void schedule(){
        int[] L = new int[] {4,8,16};
        Arrays.sort(L);


        int m = 2; // 기계 갯수
        int index = 0;
        Job job;

        while(index < L.size()) { //
            job = L.get(index);
            if ( isIdleMachine(ms, job)){
            }
            else{
                ArrayList<Job> temp = new ArrayList<Job>();
                temp.add(job);
                Machine tempM = new Machine();
                tempM.setJobs(temp);
                ms.add(tempM);
            }
            index++;
        }
        printMachine(ms);
    }

    private boolean isIdleMachine(ArrayList<Machine> ms, Job job) {
        boolean returnData = false;
        int j;
        int jobStartTime = j.getStart();
        ArrayList<Integer> mJobs;
        Machine[] m;
        for( Machine tempM : m ){
            if(tempM.getIsIdle(jobStartTime)){
                mJobs = tempM.getJobs();
                mJobs.add(j);
                return true;
            }
        }
        return returnData;
    }


    private ArrayList<Job> getJobs() {
        ArrayList<Job> returnData = new ArrayList<Job>();
        File f = new File("L.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String r = "";
            String[] ra;
            Job job;
            int s,e;
            while((r = br.readLine()) != null) {
                ra = r.split(",");
                s = Integer.parseInt(ra[0]);
                e = Integer.parseInt(ra[1]);
                job = new Job(s,e);
                returnData.add(job);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(br != null)
                    br.close();
                if(fr != null)
                    br.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return returnData;
    }


    private void printMachine(ArrayList<Machine> ms) {
        int index = 1;
        Machine[] m;
        for(Machine tempM : m){
            System.out.println("machine number: " + index + tempM);
        }
    }

    private Serializable arraysort(ArrayList<Job> jobs){
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(job o1, job o2){
                return o1.getStart() - o2.getStart();
                
            )};
         }
    }

}






