# Design Document

## Overview

This project is a Java-based heads-up Texas Hold’em poker simulator that allows a human user to play against a computer opponent and includes a Monte Carlo–based equity calculator. The primary goal of the project was to model decision-making under uncertainty while managing complex game state, rather than to optimize for production-level software architecture.

The simulator supports full betting rounds (pre-flop through river), complete hand evaluation with proper tie-breaking, and probabilistic equity estimation through randomized simulation.

---

## Design Goals

The main design goals were:

1. **Correctness over elegance**  
   Poker hand evaluation and betting logic involve many edge cases. Correctness and clarity of logic were prioritized over architectural cleanliness.

2. **Explicit state management**  
   The game maintains clear state transitions between betting rounds, player actions, and showdowns to avoid hidden or implicit behavior.

3. **Quantitative reasoning**  
   The Monte Carlo simulator is designed to approximate hand equity accurately through repeated random trials rather than closed-form enumeration.

---

## Monte Carlo Simulation Approach

The equity calculator estimates the probability of winning, losing, or chopping by running a large number of independent trials.

For each trial:
1. Known cards (player hole cards, opponent hole cards, and any fixed community cards) are removed from the deck.
2. Remaining community cards are randomly sampled without replacement.
3. Final hands are evaluated and compared.
4. Outcomes are aggregated across trials.

Monte Carlo simulation was chosen because:
- Exact enumeration becomes cumbersome when partial board information is provided.
- Simulation is easy to generalize to arbitrary game states.
- Accuracy improves smoothly as the number of trials increases.

In practice, running 10,000+ trials produces stable equity estimates for most use cases.

---

## Hand Evaluation Logic

Hands are evaluated by:
- Counting card ranks to detect pairs, three-of-a-kind, four-of-a-kind, and full houses.
- Tracking suits to detect flushes.
- Identifying straights, including edge cases such as the wheel (A-2-3-4-5).
- Comparing kickers when hands are of equal rank.

The evaluation logic returns both the hand category and sufficient information to correctly break ties between hands of the same type.

---

## AI Decision-Making Strategy

The computer opponent uses a heuristic-based decision model rather than game-theoretic optimal play.

Key characteristics:
- Pre-flop decisions are based on hand strength tiers (e.g., pairs, high cards, suited cards, and connectors).
- Bet sizing varies based on perceived hand strength.
- Bluffing behavior is introduced at a controlled frequency to avoid deterministic play.

The AI is intentionally simple and interpretable. The goal was to create a reasonable opponent while keeping decision logic understandable and debuggable.

---

## State Management and Game Flow

The game explicitly tracks:
- Player stacks and pot size
- Betting actions and remaining stack constraints
- Community cards across betting rounds
- Terminal conditions such as folds and all-ins

While much of the logic is centralized for simplicity, state transitions are handled deterministically to prevent invalid game states.

---

## Tradeoffs and Limitations

This project makes several intentional tradeoffs:

- **Minimal object-oriented abstraction**  
  Many components are implemented procedurally within a single file to reduce overhead while learning core game logic.

- **Heuristic AI instead of GTO**  
  The AI does not attempt to solve for game-theoretic optimal strategies.

- **Simulation variance**  
  Monte Carlo results are stochastic; confidence intervals are not currently reported.

---

## Future Improvements

If extended further, the project could be improved by:
- Refactoring into modular classes (e.g., `Card`, `Deck`, `HandEvaluator`, `MonteCarloSimulator`)
- Adding expected value (EV) calculations for decision evaluation
- Reporting confidence intervals for Monte Carlo equity estimates
- Supporting multi-player simulations
- Porting simulation logic to Python for data analysis and visualization

---

## Key Takeaway

This project served as a practical introduction to probabilistic modeling, simulation-based analysis, and adversarial decision-making in imperfect-information games. It emphasizes reasoning under uncertainty rather than formal mathematical optimization.

