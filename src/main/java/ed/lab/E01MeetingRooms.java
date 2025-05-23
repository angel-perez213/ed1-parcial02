package ed.lab;

import java.util.List;
import java.util.*;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }

        // Ordenar por tiempo de inicio
        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        // Min-heap para rastrear los tiempos de finalización
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {
            if (!minHeap.isEmpty() && interval.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.endTime());
        }

        return minHeap.size();
    }
}
