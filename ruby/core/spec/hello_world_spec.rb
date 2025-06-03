require 'rspec'
require_relative '../lib/hello_world'

RSpec.describe HelloWorld do
  describe '.greet' do
    it 'returns a greeting message' do
      expect(HelloWorld.greet('Ruby')).to eq('Hello Ruby!')
    end
  end
end
