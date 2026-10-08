;;; Sierra Script 1.0 - (do not remove this comment)
(script# 35)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aPippin 0
)

(instance aPippin of MuseumActor
	(properties
		sel_20 {aPippin}
		sel_213 1
		sel_214 1882
		sel_648 822
		sel_620 350
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(2
				(if (not (proc0_3 110))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
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
				(cond 
					(
					(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
					((proc27_0 5 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
					(else
						(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
						(proc27_1 5 @[global296 (- temp1 2)])
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(super sel_145: &rest)
		(proc0_3 1)
		(self sel_111:)
	)
)
