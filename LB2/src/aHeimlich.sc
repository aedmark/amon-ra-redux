;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aHeimlich 0
)

(instance aHeimlich of MuseumActor
	(properties
		sel_20 {aHeimlich}
		sel_213 1
		sel_214 1889
		sel_51 2
		sel_620 350
	)

	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(6
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(gCurRoom sel_422: (ScriptID 20 0)) ; inNotebook
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256
							(+ temp2 1)
						)
						(512
							(+ temp2 18)
						)
						(768
							(+ temp2 26)
						)
						(1024
							(+ temp2 61)
						)
					)
				)
				(switch temp0
					(259
						(cond
							((or (IsFlag 171) (IsFlag 12))
								(if (proc27_0 2 global363)
									(gMessager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gMessager sel_295: sel_213 6 69 0 0 sel_214)
									(proc27_1 2 @global363)
								)
							)
							((proc27_0 2 global298)
								(gMessager sel_295: sel_213 6 1 0 0 sel_214)
							)
							(else
								(gMessager sel_295: sel_213 6 4 0 0 sel_214)
								(proc27_1 2 @global298)
							)
						)
					)
					(264
						(cond
							((or (IsFlag 143) (IsFlag 72))
								(if (proc27_0 2 global366)
									(gMessager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gMessager sel_295: sel_213 6 74 0 0 sel_214)
									(proc27_1 2 @global366)
								)
							)
							((proc27_0 2 global303)
								(gMessager sel_295: sel_213 6 1 0 0 sel_214)
							)
							(else
								(gMessager sel_295: sel_213 6 9 0 0 sel_214)
								(proc27_1 2 @global303)
							)
						)
					)
					(266
						(cond
							((or (IsFlag 161) (IsFlag 68))
								(if (proc27_0 2 global367)
									(gMessager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gMessager sel_295: sel_213 6 73 0 0 sel_214)
									(proc27_1 2 @global367)
								)
							)
							((proc27_0 2 global305)
								(gMessager sel_295: sel_213 6 1 0 0 sel_214)
							)
							(else
								(gMessager sel_295: sel_213 6 11 0 0 sel_214)
								(proc27_1 2 @global305)
							)
						)
					)
					(267
						(cond
							((or (IsFlag 158) (IsFlag 67))
								(if (proc27_0 2 global365)
									(gMessager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gMessager sel_295: sel_213 6 71 0 0 sel_214)
									(proc27_1 2 @global365)
								)
							)
							((proc27_0 2 global306)
								(gMessager sel_295: sel_213 6 1 0 0 sel_214)
							)
							(else
								(gMessager sel_295: sel_213 6 12 0 0 sel_214)
								(proc27_1 2 @global306)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET sel_214 sel_213 6 temp1 1))
								(gMessager sel_295: sel_213 6 81 0 0 sel_214)
							)
							((proc27_0 2 [global296 (- temp1 2)])
								(gMessager sel_295: sel_213 6 1 0 0 sel_214)
							)
							(else
								(gMessager sel_295: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 2 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else
				(super sel_300: param1)
			)
		)
	)
)
