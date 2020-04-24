import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int voteTableSize = Integer.parseInt(br.readLine());
        int voteNumber = Integer.parseInt(br.readLine());
        int enteredStudent = 0;
        Student[] student = new Student[101];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < voteNumber; i++) {
            int studentNumber = Integer.parseInt(st.nextToken());

            if (student[studentNumber] != null) {
                student[studentNumber].increaseRecommendCount();
                continue;
            }

            if (enteredStudent < voteTableSize) {
                student[studentNumber] = new Student(i, 1);
                enteredStudent += 1;
                continue;
            }

            int minStudentNumber = findMinRecommendStudent(student);

            student[minStudentNumber] = null;
            student[studentNumber] = new Student(i, 1);
        }

        for (int i = 1; i < 101; i++) {
            if (voteTableSize == 0) {
                break;
            }

            if (student[i] != null) {
                bw.write(Integer.toString(i) + " ");
                voteTableSize -= 1;
            }
        }

        bw.flush();
        bw.close();
    }

    private static int findMinRecommendStudent(Student[] student) {
        int minStudentNumber = 0;

        for (int i = 1; i < 101; i++) {
            if (student[i] == null) {
                continue;
            }

            int compareStudentCount = student[i].recommendCount;

            if (minStudentNumber == 0) {
                minStudentNumber = i;
                continue;
            }

            int minStudentCount = student[minStudentNumber].recommendCount;

            if (compareStudentCount > minStudentCount) {
                continue;
            }

            if (compareStudentCount < minStudentCount) {
                minStudentNumber = i;
                continue;
            }

            if (compareStudentCount == minStudentCount) {
                if (student[i].recommendTime - student[minStudentNumber].recommendTime < 0) {
                    minStudentNumber = i;
                }
            }
        }

        return minStudentNumber;
    }
}

class Student {
    public int recommendTime;
    public int recommendCount;

    public Student(int recommendTime, int recommendCount) {
        this.recommendTime = recommendTime;
        this.recommendCount = recommendCount;
    }

    public void increaseRecommendCount() {
        this.recommendCount += 1;
    }
}