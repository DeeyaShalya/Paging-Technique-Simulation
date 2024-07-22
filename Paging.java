import java.util.*;

public class Paging {

    private int frameSize;
    private List<Integer> pageSequence;
    private List<Integer> frames;
    private String algorithm;
    private int pageFaults;

    public Paging(int frameSize, List<Integer> pageSequence, String algorithm) {
        this.frameSize = frameSize;
        this.pageSequence = pageSequence;
        this.algorithm = algorithm;
        this.frames = new ArrayList<>(Collections.nCopies(frameSize, -1));
        this.pageFaults = 0;
    }

    public void simulatePaging() {
        switch (algorithm.toLowerCase()) {
            case "fifo":
                simulateFIFO();
                break;
            case "lru":
                simulateLRU();
                break;
            case "optimal":
                simulateOptimal();
                break;
            default:
                System.out.println("Invalid algorithm selected.");
                break;
        }
    }

    private void simulateFIFO() {
        Queue<Integer> fifoQueue = new LinkedList<>();
        for (int page : pageSequence) {
            if (!frames.contains(page)) {
                pageFaults++;
                if (fifoQueue.size() >= frameSize) {
                    int removedPage = fifoQueue.poll();
                    frames.set(frames.indexOf(removedPage), page);
                } else {
                    frames.set(fifoQueue.size(), page);
                }
                fifoQueue.add(page);
            }
            displayFrames();
        }
    }

    private void simulateLRU() {
        List<Integer> lruList = new ArrayList<>();
        for (int page : pageSequence) {
            if (!frames.contains(page)) {
                pageFaults++;
                if (lruList.size() >= frameSize) {
                    int removedPage = lruList.remove(0);
                    frames.set(frames.indexOf(removedPage), page);
                } else {
                    frames.set(lruList.size(), page);
                }
            } else {
                lruList.remove((Integer) page);
            }
            lruList.add(page);
            displayFrames();
        }
    }

    private void simulateOptimal() {
        for (int i = 0; i < pageSequence.size(); i++) {
            int page = pageSequence.get(i);
            if (!frames.contains(page)) {
                pageFaults++;
                if (frames.contains(-1)) {
                    frames.set(frames.indexOf(-1), page);
                } else {
                    int pageToReplace = findOptimalPageToReplace(i);
                    frames.set(frames.indexOf(pageToReplace), page);
                }
            }
            displayFrames();
        }
    }

    private int findOptimalPageToReplace(int currentIndex) {
        List<Integer> futurePages = pageSequence.subList(currentIndex + 1, pageSequence.size());
        Map<Integer, Integer> pageNextUse = new HashMap<>();
        for (int frame : frames) {
            pageNextUse.put(frame, futurePages.indexOf(frame) != -1 ? futurePages.indexOf(frame) : Integer.MAX_VALUE);
        }
        return Collections.max(pageNextUse.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private void displayFrames() {
        System.out.println("Frames: " + frames);
    }

    public int getPageFaults() {
        return pageFaults;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter frame size: ");
        int frameSize = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter page sequence (comma-separated): ");
        String pageSequenceStr = scanner.nextLine();
        String[] pages = pageSequenceStr.split(",");
        List<Integer> pageSequence = new ArrayList<>();
        for (String page : pages) {
            pageSequence.add(Integer.parseInt(page.trim()));
        }

        System.out.print("Enter replacement algorithm (FIFO, LRU, Optimal): ");
        String algorithm = scanner.nextLine();

        Paging paging = new Paging(frameSize, pageSequence, algorithm);
        paging.simulatePaging();
        System.out.println("Total Page Faults: " + paging.getPageFaults());
    }
}
