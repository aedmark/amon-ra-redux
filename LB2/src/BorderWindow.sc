;;; Sierra Script 1.0 - (do not remove this comment)
(script# 936)
(include sci.sh)
(use SysWindow)


(procedure (localproc_0203 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 &tmp temp0 temp1)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param3 1)
		(+ param4 1)
		param13
		param5
		param12
	)
	(= param1 (- param1 param10))
	(= param2 (- param2 param10))
	(= param4 (+ param4 param10))
	(= param3 (+ param3 param10))
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param1 param10)
		param4
		param13
		param6
		param12
	)
	(Graph
		grFILL_BOX
		(- param3 param10)
		param2
		param3
		param4
		param13
		param8
		param12
	)
	(= temp1 0)
	(while (< temp1 param10)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(+ param2 temp1)
			(- param3 (+ temp1 1))
			(+ param2 temp1)
			param7
			param12
			-1
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(- param4 (+ temp1 1))
			(- param3 (+ temp1 1))
			(- param4 (+ temp1 1))
			param9
			param12
			-1
		)
		(++ temp1)
	)
	(if param11
		(Graph
			grFILL_BOX
			(+ param1 param11)
			param4
			(+ param3 param11)
			(+ param4 param11)
			param13
			0
			param12
		)
		(Graph
			grFILL_BOX
			param3
			(+ param2 param11)
			(+ param3 param11)
			param4
			param13
			0
			param12
		)
	)
	(SetPort temp0)
)

(class BorderWindow of SysWindow
	(properties
		sel_20 {BorderWindow}
		sel_193 0
		sel_194 0
		sel_195 0
		sel_196 0
		sel_25 0
		sel_26 5
		sel_60 15
		sel_32 0
		sel_31 0
		sel_77 0
		sel_16 0
		sel_17 0
		sel_18 190
		sel_19 320
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_236 0
		sel_367 7
		sel_368 6
		sel_369 4
		sel_370 3
		sel_371 3
		sel_372 2
	)
	
	(method (sel_111)
		(super sel_111:)
		(SetPort 0)
	)
	
	(method (sel_189 &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= sel_60 -1) (= temp1 (| temp1 $0002)))
		(= sel_10 (- sel_193 sel_371))
		(= sel_11 (- sel_194 sel_371))
		(= sel_13 (+ sel_196 sel_371 sel_372))
		(= sel_12 (+ sel_195 sel_371 sel_372))
		(= sel_31 128)
		(super sel_189:)
		(localproc_0203
			sel_193
			sel_194
			sel_195
			sel_196
			sel_26
			sel_367
			sel_368
			sel_370
			sel_369
			sel_371
			sel_372
			sel_60
			temp1
		)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX sel_10 sel_11 sel_12 sel_13 1)
		(SetPort temp0)
	)
)

(class InsetWindow of BorderWindow
	(properties
		sel_20 {InsetWindow}
		sel_193 0
		sel_194 0
		sel_195 0
		sel_196 0
		sel_25 0
		sel_26 5
		sel_60 15
		sel_32 0
		sel_31 0
		sel_77 0
		sel_16 0
		sel_17 0
		sel_18 190
		sel_19 320
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_236 0
		sel_367 5
		sel_368 4
		sel_369 2
		sel_370 1
		sel_371 3
		sel_372 2
		sel_373 3
		sel_374 2
		sel_375 0
		sel_376 1
		sel_377 5
		sel_378 4
		sel_379 10
		sel_380 24
		sel_381 2
		sel_382 0
		sel_383 2
		sel_384 0
		sel_385 0
	)
	
	(method (sel_189 &tmp temp0 temp1 theSel_193 theSel_194 theSel_195 theSel_196)
		(= temp0 1)
		(if (!= sel_60 -1) (= temp0 (| temp0 $0002)))
		(= theSel_193 sel_193)
		(= theSel_194 sel_194)
		(= theSel_195 sel_195)
		(= theSel_196 sel_196)
		(= sel_193 (- sel_193 (+ sel_371 sel_379)))
		(= sel_194 (- sel_194 (+ sel_371 sel_381)))
		(= sel_195 (+ sel_195 sel_371 sel_380))
		(= sel_196 (+ sel_196 sel_371 sel_381))
		(= sel_384 (+ sel_371 sel_381))
		(= sel_385 (+ sel_371 sel_379))
		(super sel_189:)
		(localproc_0203
			theSel_193
			theSel_194
			theSel_195
			theSel_196
			sel_374
			sel_375
			sel_376
			sel_377
			sel_378
			sel_383
			sel_382
			sel_60
			temp0
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- theSel_193 sel_383)
			(- theSel_194 sel_383)
			(+ theSel_195 sel_383)
			(+ theSel_196 sel_383)
			1
		)
		(SetPort temp1)
	)
)
