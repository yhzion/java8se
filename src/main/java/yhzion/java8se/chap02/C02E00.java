package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C02E00 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordAsList();

        long count = 0;
        for (String word : words) {
            if (word.length() > 10) count++;
        }

        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 10).count();

        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 10).count();

        System.out.println(count);

        Stream.of(getWordAsArray());

        Stream.of("gently", "down", "the", "stream");

        Stream.empty();

        Arrays.stream(getWordAsArray(), 1, 2);

        Stream.generate(() -> "Echo");

        Stream.generate(Math::random);

        Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

        Stream.generate(Math::random).skip(5).limit(5).forEach(System.out::println);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> languageNames = locales.collect(
                Collectors.toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }
                )
        );

        System.out.println(languageNames.get("Switzerland"));

        locales = Stream.of(Locale.getAvailableLocales());
        languageNames = locales.collect(
                Collectors.toConcurrentMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }
                )
        );

        System.out.println(languageNames.get("Switzerland"));

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = locales.collect(
                Collectors.groupingBy(Locale::getCountry)
        );

        List<Locale> swissLocales = countryToLocales.get("CH");
        swissLocales.forEach(System.out::println);

        //영어를 사용하는 경우와 그렇지 않은 경우 표시
        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("en"))
        );

        englishAndOtherLocales.get(false).forEach(System.out::println);
    }
}
