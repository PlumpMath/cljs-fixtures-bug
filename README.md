# cljs-fixtures-bug

Reproduce an error regarding `cljs.test/use-fixtures`.

## Reproduce

Compile in auto mode with:

```sh
java -cp cljs.jar:src clojure.main script/node.clj
```

when the compilation is done, run `node out/testable.js` on another
tab. You should see

> Testing fixtures.core-test
>
> Ran 0 tests containing 0 assertions.
> 0 failures, 0 errors.

which implies there are no tests in `fixtures.core-test`. Now edit
`src/fixtures/core_test.cljs` by removing `(use-fixtures :once
inc-counter)`:

```diff

(defn inc-counter [& args]
  (swap! counter inc))

-(use-fixtures :once inc-counter)

(deftest fixture
  (is (= 1 @counter)))

```

The compilation should restart, and when is done, run `node
out/testable.js` again. You should see this:

> Testing fixtures.core-test
>
> FAIL in (fixture) (cljs/test.js:418:14)
> expected: (= 1 (clojure.core/deref counter))
>   actual: (not (= 1 0))
>
> Ran 2 tests containing 2 assertions.
> 1 failures, 0 errors.

which implies that the tests can't be found when `use-fixtures` is used.
