package linkedlist;

/**
 * @author voyageth 2016-10-20
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> firstLevelList = new DoubleLinkedList<>();
        DoubleLinkedListItem<Integer> firstLevel1 = new DoubleLinkedListItem<>(5);
        DoubleLinkedListItem<Integer> firstLevel4 = new DoubleLinkedListItem<>(2);
        firstLevelList.append(firstLevel1);
        firstLevelList.append(new DoubleLinkedListItem<>(33));
        firstLevelList.append(new DoubleLinkedListItem<>(17));
        firstLevelList.append(firstLevel4);
        firstLevelList.append(new DoubleLinkedListItem<>(1));

        DoubleLinkedList<Integer> secondLevelList1 = new DoubleLinkedList<>();
        DoubleLinkedListItem<Integer> secondLevel1 = new DoubleLinkedListItem<>(6);
        DoubleLinkedListItem<Integer> secondLevel2 = new DoubleLinkedListItem<>(25);
        DoubleLinkedListItem<Integer> secondLevel3 = new DoubleLinkedListItem<>(6);
        secondLevelList1.append(secondLevel1);
        secondLevelList1.append(secondLevel2);
        secondLevelList1.append(secondLevel3);
        DoubleLinkedList<Integer> secondLevelList2 = new DoubleLinkedList<>();
        DoubleLinkedListItem<Integer> secondLevel4 = new DoubleLinkedListItem<>(2);
        secondLevelList2.append(secondLevel4);
        secondLevelList2.append(new DoubleLinkedListItem<>(7));

        DoubleLinkedList<Integer> thirdLevelList1 = new DoubleLinkedList<>();
        thirdLevelList1.append(new DoubleLinkedListItem<>(8));
        DoubleLinkedList<Integer> thirdLevelList2 = new DoubleLinkedList<>();
        DoubleLinkedListItem<Integer> thirdLevel2 = new DoubleLinkedListItem<>(9);
        thirdLevelList2.append(thirdLevel2);
        DoubleLinkedList<Integer> thirdLevelList3 = new DoubleLinkedList<>();
        DoubleLinkedListItem<Integer> thirdLevel3 = new DoubleLinkedListItem<>(12);
        thirdLevelList3.append(thirdLevel3);
        thirdLevelList3.append(new DoubleLinkedListItem<>(5));

        DoubleLinkedList<Integer> fourthLevelList1 = new DoubleLinkedList<>();
        fourthLevelList1.append(new DoubleLinkedListItem<>(7));
        DoubleLinkedList<Integer> fourthLevelList2 = new DoubleLinkedList<>();
        fourthLevelList2.append(new DoubleLinkedListItem<>(21));
        fourthLevelList2.append(new DoubleLinkedListItem<>(3));

        firstLevel1.setChild(secondLevelList1.getHead());
        firstLevel4.setChild(secondLevelList2.getHead());
        secondLevel2.setChild(thirdLevelList1.getHead());
        secondLevel3.setChild(thirdLevelList2.getHead());
        secondLevel4.setChild(thirdLevelList3.getHead());
        thirdLevel2.setChild(fourthLevelList1.getHead());
        thirdLevel3.setChild(fourthLevelList2.getHead());

        firstLevelList.print(true);
        firstLevelList.flattenList();
        firstLevelList.print(false);
        firstLevelList.unflattenList();
        firstLevelList.print(true);
    }
}
