module Main where

import MyLib (greet)

main :: IO ()
main = putStrLn (greet "World")
