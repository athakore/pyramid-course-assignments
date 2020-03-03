package pyramid_course_assignments;

 import clojure.lang.RT;
 import clojure.lang.Var;

 import java.io.IOException;

 public class LoadTestFile {
     static {
         try {
             RT.loadResourceScript("core.clj");
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public static Var hello_world_test = RT.var("core", "hello-world-test");
     public static Var primitive_datatypes_test = RT.var("core", "primitive-datatypes-test");
     public static Var variable_assignment_test = RT.var("core", "variable-assignment-test");
     public static Var increment_test = RT.var("core", "increment-test");
     public static Var string_manipulation_test = RT.var("core", "string-manipulation-test");
     public static Var user_input_assignment_test = RT.var("core", "user-input-test");
     public static Var if_statement_test = RT.var("core", "if-statement-test");
     public static Var if_else_test = RT.var("core", "if-else-test");
     public static Var logical_statements_test = RT.var("core", "logical-statements-test");
     public static Var switch_it_up_test = RT.var("core", "switch-it-up-test");
     public static Var while_loop_test = RT.var("core", "while-loop-test");
     public static Var even_after_odds_test = RT.var("core", "even-after-odds-test");
     public static Var squaring_an_array_test = RT.var("core", "squaring-an-array-test");
     public static Var add_one_to_array_list_test = RT.var("core", "add-one-to-array-list-test");
     public static Var last_index_found_test = RT.var("core", "last-index-found-test");
     public static Var access_modifiers_test = RT.var("core", "access-modifiers-test");
     public static Var insert_element_at_random_position_test = RT.var("core", "insert-element-at-random-position-test");
     public static Var sum_array_using_reduce_test = RT.var("core", "sum-array-using-reduce-test");
     public static Var creating_methods_test = RT.var("core", "creating-methods-test");
     public static Var find_the_duplicates_in_an_array_test = RT.var("core", "find-the-duplicates-in-an-array-test");
     public static Var outgoing_calls_from_bangalore_test = RT.var("core", "outgoing-calls-from-bangalore-test");
     public static Var find_the_missing_integer_test = RT.var("core", "find-the-missing-integer-test");
     public static Var remove_odds_from_array_test = RT.var("core", "remove-odds-from-array-test");
     public static Var sum_array_test = RT.var("core", "sum-array-test");
     public static Var do_while_test = RT.var("core", "do-while-test");
     public static Var reverse_integer_using_arrays_test = RT.var("core", "reverse-integer-using-arrays-test");
     public static Var total_number_of_calls_test = RT.var("core", "total-number-of-calls-test");
     public static Var objects_test = RT.var("core", "objects-test");
     public static Var fast_stair_climber_test = RT.var("core", "fast-stair-climber-test");
     public static Var constructors_test = RT.var("core", "constructors-test");
     public static Var find_max_and_min_in_array_test = RT.var("core", "find-max-and-min-in-array-test");
     public static Var nth_row_pascal_test = RT.var("core", "nth-row-pascal-test");
     public static Var first_record_of_texts_last_record_of_calls_test = RT.var("core", "first-record-of-texts-last-record-of-calls-test");
     public static Var find_keypad_combos_test = RT.var("core", "find-keypad-combos-test");
     public static Var for_loop_test = RT.var("core", "for-loop-test");
     public static Var max_sub_array_test = RT.var("core", "max-sub-array-test");
     public static Var longest_call_test = RT.var("core", "longest-call-test");
     public static Var reverse_array_test = RT.var("core", "reverse-array-test");
     public static Var count_duplicates_with_hashmap_test = RT.var("core", "count-duplicates-with-hashmap-test");
     public static Var removing_odds_ensuring_filter_is_used_test = RT.var("core", "removing-odds-ensuring-filter-is-used-test");
     public static Var count_duplicates_with_hashmap_ensuring_hashmap_was_used_test = RT.var("core", "count-duplicates-with-hashmap-ensuring-hashmap-was-used-test");
     public static Var squaring_an_array_ensuring_map_is_used_test = RT.var("core", "squaring-an-array-ensuring-map-is-used-test");
     public static Var check_to_see_if_array_contains_a_number_test = RT.var("core", "check-to-see-if-array-contains-a-number-test");
     public static Var ensuring_sum_array_using_reduce_test = RT.var("core", "ensuring-sum-array-using-reduce-test");
     public static Var creating_a_stream_from_an_array_test = RT.var("core", "creating-a-stream-from-an-array-test");
     public static Var reverse_a_string_reduce_test = RT.var("core", "reverse-a-string-reduce-test");
     public static Var remove_duplicates_from_array_test = RT.var("core", "remove-duplicates-from-array-test");
     public static Var number_of_binary_search_trees_test = RT.var("core", "number-of-binary-search-trees-test");
     public static Var animal_test = RT.var("core", "animal-test");
     public static Var potential_telemarketers_test = RT.var("core", "potential-telemarketers-test");
     public static Var steps_to_take_test = RT.var("core", "steps-to-take-test");
     public static Var remove_duplicates_with_a_set_test = RT.var("core", "remove-duplicates-with-a-set-test");
     public static Var ensuring_reverse_a_string_reduce_test = RT.var("core", "ensuring-reverse-a-string-reduce-test");

 }
