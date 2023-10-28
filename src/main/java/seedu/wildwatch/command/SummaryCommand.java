package seedu.wildwatch.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seedu.wildwatch.entry.Entry;
import seedu.wildwatch.entry.EntryList;
import seedu.wildwatch.exception.IncorrectInputException;
import seedu.wildwatch.operation.Ui;

/**
 * Command class for `summary`
 */
public class SummaryCommand extends Command {
    public static Map<String, List<Entry>> groupEntriesBySpecies(List<Entry> entries) {

        Map<String, List<Entry>> map = new HashMap<String, List<Entry>>();
        for (Entry entry : entries) {
            String key = entry.getSpecies();
            if(map.containsKey(key)){
                List<Entry> list = map.get(key);
                list.add(entry);
            }else{
                List<Entry> list = new ArrayList<Entry>();
                list.add(entry);
                map.put(key, list);
            }
        }
        return map;
    }
    public static Map<String, List<Entry>> groupSpecieByName(List<Entry> filteredEntries) {
        Map<String, List<Entry>> filteredMap = new HashMap<String, List<Entry>>();

        for (Entry entry : filteredEntries) {
            String key = entry.getName();
            if(filteredMap.containsKey(key)){
                List<Entry> list = filteredMap.get(key);
                list.add(entry);
            }else{
                List<Entry> list = new ArrayList<Entry>();
                list.add(entry);
                filteredMap.put(key, list);
            }
        }
        return filteredMap;
    }
    public static void showSummary(String inputBuffer) throws IncorrectInputException {
        String argument = inputBuffer.replace("summary","").trim();
        String speciesName = argument;
        boolean hasArgument = !argument.isEmpty();

        ArrayList<Entry> entries = EntryList.getArray();
        // Group entries by .species attribute
        Map<String, List<Entry>> map = groupEntriesBySpecies(entries);
        // change message based on whether `summary` or `summary <species>`
        if( hasArgument ) {
            Ui.printSummaryNameMessage(speciesName);
            List<Entry> filteredEntries = map.get(speciesName);
            Map<String, List<Entry>> filteredMap = groupSpecieByName(filteredEntries);
            filteredMap.forEach((key, value) -> System.out.println(key + " - (" + value.size() + ")"));
        } else {
            Ui.printSummarySpecieMessage();
            map.forEach((key, value) -> System.out.println(key + " - (" + value.size() + ")"));
        }
    }
}
