module Main (main) where

import Test.Hspec
import MyLib (greet)

main :: IO ()
main = hspec $ do
  describe "greet" $ do
    it "greets a person" $ do
      greet "Saeid" `shouldBe` "Hello, Saeid!"
