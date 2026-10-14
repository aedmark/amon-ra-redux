;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use eRS)
(use ego)
(use Print)

(public
	whereTo 0
)

(instance whereTo of LBRoom
	(properties
		name {whereTo}
		picture 780
	)

	(method (init &tmp [temp0 10] temp10 temp11)
		(super init:)
		(= temp0 0)
		(= temp10 0)
		(= temp10
			(Print
				addText: 2 0 4 1 0 0 10
				addEdit: @temp0 5 115 0
				addButton: 105 2 0 0 1 0 18 10
				addButton: 140 2 0 0 2 100 18 10
				addButton: 210 2 0 0 3 0 36 10
				addButton: 260 2 0 0 4 100 36 10
				addButton: 280 2 0 0 5 0 54 10
				addButton: 300 2 0 0 6 100 54 10
				addButton: -200 2 0 0 7 0 72 10
				addButton: 250 2 0 0 8 100 72 10
				addButton: -300 2 0 0 33 0 90 10
				addButton: -100 2 0 0 9 100 90 10
				init:
			)
		)
		(if temp0
			(= temp10 (ReadNumber @temp0))
		)
		(if (== temp10 -100)
			(gGame restore:)
			(= temp10 0)
		)
		(if (== temp10 -300)
			(switch
				(= temp10
					(Print
						addText: 2 0 4 3 0 0 10
						addButton: 1 2 0 3 1 0 20 10
						addButton: 2 2 0 3 2 0 40 10
						addButton: 3 2 0 3 3 0 60 10
						addButton: 4 2 0 3 4 0 80 10
						addButton: 5 2 0 3 5 0 100 10
						addButton: 6 2 0 3 6 0 120 10
						init:
					)
				)
				(1
					(= gAct 0)
					(= gScore 0)
				)
				(2
					(proc0_13)
					(= gAct 1)
					(= gScore 5)
				)
				(3
					(proc0_14)
					(= gAct 2)
					(= gScore 12)
				)
				(4
					(proc0_15)
					(= gAct 3)
					(= gScore 43)
				)
				(5
					(proc0_16)
					(= gAct 4)
					(= gScore 58)
				)
				(6
					(proc0_17)
					(= gAct 5)
					(= gScore 61)
				)
			)
			(= temp10 26)
			(ego get: -1 2)
		)
		(if (== temp10 -200)
			(= temp10 -1)
			(= temp11 0)
			(while (== temp10 -1)
				(if (not temp11)
					(Print
						addText: 2 0 4 2 0 0 10
						addEdit: @temp0 5 165 0
						addButton: 350 2 0 0 10 0 18 10
						addButton: 420 2 0 0 12 140 18 10
						addButton: 430 2 0 0 13 0 36 10
						addButton: 440 2 0 0 14 140 36 10
						addButton: 450 2 0 0 15 0 54 10
						addButton: 480 2 0 0 16 140 54 0
					)
					(= temp10
						(Print
							addButton: 490 2 0 0 17 0 72 10
							addButton: 500 2 0 0 18 140 72 10
							addButton: 560 2 0 0 19 0 90 10
							addButton: 520 2 0 0 20 140 90 10
							addButton: 550 2 0 0 21 0 108 10
							addButton: -1 2 0 0 23 140 108 10
							init:
						)
					)
				else
					(= temp10
						(Print
							addText: 2 0 4 2 0 0 10
							addEdit: @temp0 5 165 0
							addButton: 600 2 0 0 24 0 18 10
							addButton: 650 2 0 0 25 140 18 10
							addButton: 610 2 0 0 26 0 36 10
							addButton: 630 2 0 0 27 140 36 10
							addButton: 640 2 0 0 32 0 54 10
							addButton: 730 2 0 0 28 140 54 10
							addButton: 720 2 0 0 29 0 72 10
							addButton: 710 2 0 0 30 140 72 10
							addButton: 700 2 0 0 31 0 90 10
							addButton: -1 2 0 0 23 140 90 10
							init:
						)
					)
				)
				(if temp0
					(= temp10 (ReadNumber @temp0))
				)
				(if (== temp10 -1)
					(= temp11 (- 1 temp11))
				)
			)
		)
		(if (not temp10)
			(= temp10 105)
		)
		(self newRoom: temp10)
	)
)
