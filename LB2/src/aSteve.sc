;;; Sierra Script 1.0 - (do not remove this comment)
(script# 37)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aSteve 0
)

(instance aSteve of MuseumActor
	(properties
		sel_20 {aSteve}
		sel_213 1
		sel_214 1887
		sel_103 1
		sel_648 812
		sel_620 370
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(1
				(switch global123
					(1
						(gLb2Messager sel_295: sel_213 param1 0 0 0 sel_214)
					)
					(5
						(gLb2Messager sel_295: sel_213 param1 27 0 0 sel_214)
					)
					(else 
						(gLb2Messager sel_295: sel_213 param1 24 0 0 sel_214)
					)
				)
			)
			(6
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(switch temp0
					(258
						(cond 
							((proc0_2 134)
								(if (proc27_0 10 global364)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
									(proc27_1 10 @global364)
								)
							)
							((proc27_0 10 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
								(proc27_1 10 @global297)
							)
						)
					)
					(else 
						(cond 
							(
							(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
							((proc27_0 10 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 10 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)
